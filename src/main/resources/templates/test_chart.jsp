<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*,java.io.Reader,java.io.IOException,java.lang.*,javax.naming.InitialContext,javax.sql.DataSource,javax.naming.Context" %> 
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dynamic Bar Chart</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script type="text/javascript">
        // JavaScript 함수와 변수는 아래에 정의
    </script>
</head>
<body>

<%
    // 데이터베이스 연결 및 쿼리 실행
    Context initContext = new InitialContext(); 
    Context envContext  = (Context) initContext.lookup("java:/comp/env");    
    DataSource dataSource = (DataSource) envContext.lookup("jdbc/oracle");    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();


    try {
        conn = dataSource.getConnection();
        stmt = conn.createStatement();

        String sql = "SELECT  PRC_DATE,GUBN,CUST_NAME,HOUR_09,HOUR_10,HOUR_11,HOUR_12,HOUR_13,HOUR_14,HOUR_15,HOUR_16,HOUR_17,HOUR_18,HOUR_09+HOUR_10+HOUR_11+HOUR_12+HOUR_13+HOUR_14+HOUR_15+HOUR_16+HOUR_17+HOUR_18,PJN FROM (                                  "+
"  SELECT TO_CHAR(IN_DATE, 'YYYYMMDD') PRC_DATE,'처리완료' GUBN                    "+
"      ,(SELECT CUST_NAME FROM TCNT01 WHERE CUST_CODE  = A.CUST_CODE) CUST_NAME                    "+
" 	,(SELECT PROJECT_NAME FROM TPRJ01 WHERE CUST_CODE = A.CUST_CODE AND PROJECT_CODE=A.PROJECT_CODE)PJN		"+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '09', 1, 0)) HOUR_09                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '10', 1, 0)) HOUR_10                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '11', 1, 0)) HOUR_11                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '12', 1, 0)) HOUR_12                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '13', 1, 0)) HOUR_13                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '14', 1, 0)) HOUR_14                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '15', 1, 0)) HOUR_15                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '16', 1, 0)) HOUR_16                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '17', 1, 0)) HOUR_17                    "+
", SUM(DECODE(TO_CHAR(IN_DATE, 'HH24'), '18', 1, 0)) HOUR_18                    "+
"   FROM TBND01 A                    "+
"WHERE 1=1                    "+
"      AND PRC_GUBN IN ('1', '2')                    "+
"AND TO_CHAR(IN_DATE, 'YYYYMMDD') = TO_CHAR(SYSDATE,'YYYYMMDD')                    "+
"GROUP BY TO_CHAR(IN_DATE, 'YYYYMMDD'),CUST_CODE,PROJECT_CODE                    "+
"UNION ALL                    "+
"SELECT SUBSTR(REPLACE(CALLDATE,'-',''), 1,8) PRC_DATE ,'미수신'GUBN                    "+
"        ,(SELECT CUST_NAME FROM TCNT01 WHERE CUST_CODE  = A.CUST_CODE) CUST_NAME                    "+
"		 ,PJN																						"+
"        , SUM(DECODE(SUBSTR(CALLDATE, 12,2), '09', 1, 0)) HOUR_09                    "+
"        , SUM(DECODE(SUBSTR(CALLDATE, 12,2), '10', 1, 0)) HOUR_10                    "+
"        , SUM(DECODE(SUBSTR(CALLDATE, 12,2), '11', 1, 0)) HOUR_11                    "+
"        , SUM(DECODE(SUBSTR(CALLDATE, 12,2), '12', 1, 0)) HOUR_12                    "+
"		, SUM(DECODE(SUBSTR(CALLDATE, 12,2), '13', 1, 0)) HOUR_13                    "+
"		, SUM(DECODE(SUBSTR(CALLDATE, 12,2), '14', 1, 0)) HOUR_14                    "+
"		, SUM(DECODE(SUBSTR(CALLDATE, 12,2), '15', 1, 0)) HOUR_15                    "+
"		, SUM(DECODE(SUBSTR(CALLDATE, 12,2), '16', 1, 0)) HOUR_16                    "+
"		, SUM(DECODE(SUBSTR(CALLDATE, 12,2), '17', 1, 0)) HOUR_17                    "+
"		, SUM(DECODE(SUBSTR(CALLDATE, 12,2), '18', 1, 0)) HOUR_18                    "+
"		   FROM (SELECT B.CALLDATE,B.CLID,B.PERSON_CODE,B.CUST_CODE,B.PROJECT_CODE,B.empno,B.INCALL_NO                    "+
"                  ,(select emp_name from temp01 where empno =B.empno) emp_name                    "+
"                  ,(SELECT PROJECT_NAME FROM TPRJ01 WHERE CUST_CODE =B.CUST_CODE AND PROJECT_CODE = B.PROJECT_CODE) PJN,1 COUNT,B.RESULT,B.CONTEXT                    "+
"             FROM                     "+
"              (SELECT MAX(CALLDATE)CALL_DATE ,CLID,CUST_CODE,PROJECT_CODE                     "+
"               FROM CALL_LOG_D                     "+
"               WHERE substr(calldate,0,10)= TO_CHAR(SYSDATE,'YYYY-MM-DD')                    "+
"               GROUP BY SUBSTR(calldate,0,10) , CLID,CUST_CODE,PROJECT_CODE) A,CALL_LOG_D B                    "+
"            WHERE A.CALL_DATE = B.CALLDATE                    "+
"              AND substr(calldate,0,10) =  TO_CHAR(SYSDATE,'YYYY-MM-DD')                    "+
"              AND A.CLID = B.CLID                    "+
"              AND RESULT <>'ANSWER'   and b.context <> 'outbound'                 "+
"              ORDER BY CALLDATE DESC) a                    "+
"		WHERE 1=1                    "+
"        AND CUST_CODE IS NOT NULL                    "+
"		GROUP BY SUBSTR(REPLACE(CALLDATE,'-',''), 1,8),CUST_CODE,PROJECT_CODE)                    "+
"    ORDER BY PRC_DATE,CUST_NAME,PJN,GUBN ";

        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            JSONObject record = new JSONObject();
            record.put("PRC_DATE", rs.getString("PRC_DATE"));
            record.put("GUBN", rs.getString("GUBN"));
            record.put("CUST_NAME", rs.getString("CUST_NAME"));
            // 여기서부터 나머지 필요한 컬럼들을 추가합니다.
            dataList.add(record);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
        if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
        if (con != null) try { con.close(); } catch(SQLException ex) {}
    }
%>

<script type="text/javascript">
    let chartData = <%= dataList.toString() %>;

    function drawChart() {
        var ctx = document.getElementById('myChart').getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: chartData.map(item => item.CUST_NAME),
                datasets: [{
                    label: 'GUBN 1',
                    data: chartData.filter(item => item.GUBN === '처리완료').map(item => item.HOUR_09), // 예시로 HOUR_09을 사용
                    backgroundColor: 'rgba(54, 162, 235, 0.2)'
                }, {
                    label: 'GUBN 2',
                    data: chartData.filter(item => item.GUBN === '미수신').map(item => item.HOUR_09), // 예시로 HOUR_09을 사용
                    backgroundColor: 'rgba(255, 99, 132, 0.2)'
                }]
            }
        });
    }

    window.onload = function() {
        drawChart();
    };
</script>

<canvas id="myChart" width="400" height="400"></canvas>

</body>
</html>