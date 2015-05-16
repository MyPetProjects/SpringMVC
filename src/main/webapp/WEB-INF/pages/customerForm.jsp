<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Valentine
  Date: 11.05.15
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        nav {
            float:left;
            background-color:black;
            color:white;
        }
        footer {
            background-color:black;
            color:white;
            text-align:center;
            padding:5px;
        }
        #green {color: green;}
        .gray {color: rgb(128, 128, 128);}
        .errorblock {
            color: black;
            background-color: #ffeeee;
        }
        .error {color: rgb(256, 0, 0)}
    </style>
    <title>Register</title>
</head>
<body>
  <h3 class="gray">Input customer info</h3>
  <hr>
  <form:form method="post" commandName="customer">
      <fieldset>
          <legend>Personal information</legend>
          <form:errors path="*" element="div" cssClass="errorblock"/>
          User name:
          <form:input path="userName"/>
          <form:errors path="userName" cssClass="error"/>
          <br/>
          Password:
          <form:password path="password"/>
          <form:errors path="password" cssClass="error"/>
          <br/>
          Confirm password:
          <form:password path="confirmPassword"/>
          <form:errors path="confirmPassword" cssClass="error"/>
          <br/>
          Address:
          <form:textarea path="address" rows="5" cols="30"/>
          <form:errors path="address" cssClass="error"/>
          <br/>
          Resident:
          <form:checkbox path="resident"/>
          <br/>
          Languages:
          <form:checkbox path="languages" value="Ukrainian"/>Ukrainian
          <form:checkbox path="languages" value="Russian"/>Russian
          <form:checkbox path="languages" value="English"/>English
          <br/>
          <h4>Skills:</h4>
          <ul>
              <form:checkboxes path="skills" items="${skillSet}" element="li"/>
          </ul>
          <br/>
          <h4>Citizenship:</h4>
          <ul>
              <form:checkboxes path="citizenship" items="${citizenship}" element="li"/>
          </ul>
          <input type="submit" value="Submit"/>
      </fieldset>
  </form:form>
</body>
</html>