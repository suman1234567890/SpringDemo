<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <title>ArogyaCart</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript">
        function findAll(){
$('#MyObjectTable tr').slice(1).remove();
                $.ajax({
                        url: "/spring/find"
                      }).then(function(data) {
               $.each(data, function(idx, obj) {
                        $('#MyObjectTable tr:last').after('<tr><td>'+obj.id+'</td><td>'+obj.text+'</td></tr>');
                });
                    });


        }
function findById(){
if(document.getElementById("id").value=="" || document.getElementById("id").value==null){
   alert("Enter some value");
return ;
}
$('#MyObjectTable tr').slice(1).remove();
    var findByIdUrl="/spring/find/"+document.getElementById("id").value;
  $.ajax({
        url: findByIdUrl
    }).then(function(obj) {
       if( typeof obj != 'undefined' ){
                $('#MyObjectTable tr:last').after('<tr><td>'+obj.id+'</td><td>'+obj.text+'</td></tr>');
        }
    });
}
function insert(){
$('#MyObjectTable tr').slice(1).remove();
    var insertUrl= "/ArogyaCart/spring/put/"+document.getElementById("inputtext").value;
  $.ajax({
        url:insertUrl
    }).then(function(data) {

                alert("Success");
                findAll();
    

    });
}

        </script>
    </head>

    <body>
<table border="1"  style="width:30%">
    <tr><td></td><td>
<input type="button" value="findAll" onclick="findAll()"/>
        </td></tr><tr><td>
    <input type="text" id="id" value="" /></td><td>
    <input type="button" value="Find By Id." onclick="findById()"/></td></tr><tr><td>

    <input type="text" id="inputtext" value="" /></td><td>
    <input type="button" value="IInsert text" onclick="insert()"/></td></tr>
<tr><td>

    <input type="text" id="inputtextdelete" value="" /></td><td>
    <input type="button" value="delete by Id" onclick="deletetext()"/></td></tr>

</table>
<table border="1" id="MyObjectTable" style="width:30%">
<tr><th>id</th><th>text</th></tr>
</table>

    </body>
</html>

