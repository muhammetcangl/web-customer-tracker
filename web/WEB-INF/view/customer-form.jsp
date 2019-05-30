<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mcg
  Date: 30.05.2019
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
</head>
<body>

    <div id="container">

        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <table>
                <tbody>

                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="firstName" /></td>
                    </tr>

                    <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName" /></td>
                    </tr>

                    <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email" /></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>

                </tbody>

            </table>

        </form:form>

        <div style="clear: both;"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </div>

</body>
</html>
