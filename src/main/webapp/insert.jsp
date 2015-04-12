<%-- 
    Document   : insert
    Created on : 5-Apr-2015, 11:16:27 AM
    Author     : chintan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <script src="http://code.jquery.com/jquery.min.js"></script>
     
        <script>
            $(document).ready(function() {
                $('#register').click(function() {
                    $.ajax({
                        url: "./f/form",
                        dataType: "json",
                        contentType: 'application/json; charset=UTF-8',
                        data: JSON.stringify({"cname": $("#cname").val(),
                         
                            method: "post"
                         
                    });
                });                
            });

        </script>
    </head>
    <body>
        <form method="get" action="servlet/Person">
            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                <tr>
                    <th valign="top">Category name:</th>
                    <td><input type="text" class="inp-form" name="cname" /></td>
                    <td></td>
                </tr>
      

                <tr>
                    <th>&nbsp;</th>
                    <td valign="top">
                        <input type="submit" value="submit" class="form-submit" />
                 
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
