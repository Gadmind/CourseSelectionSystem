<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="23" background="<%=path %>/img/tbg.gif">&nbsp;我的选课&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="5%">序号</td>
					<td width="11%">课程编号</td>
					<td width="11%">课程名称</td>
					<td width="11%">课时</td>
					<td width="11%">时间</td>
					
					<td width="11%">节次</td>
					<td width="11%">上课教室</td>
					<td width="11%">授课老师</td>
		        </tr>	
				<c:forEach items="${requestScope.xuesheng_kebiao_list}" var="xuesheng_kebiao" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${sta.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xuesheng_kebiao.schedule.course.courseNum}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xuesheng_kebiao.schedule.course.courseName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xuesheng_kebiao.schedule.course.classHour}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xuesheng_kebiao.schedule.scheduleTime}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xuesheng_kebiao.schedule.section}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xuesheng_kebiao.schedule.classRoom}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xuesheng_kebiao.schedule.teacher.teacherName}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
