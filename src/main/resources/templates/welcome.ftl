<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

</head>
<body style="margin: 0; padding: 0;">

    <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
        <tr>
            <td align="center" bgcolor="#78ab46" style="padding: 40px 0 30px 0;">
                <img src="cid:logo.png" style="display: block;" />
            </td>
        </tr>
        <tr>
            <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
                <p>Dear ${firstName} ${lastName},</p>
                <p>Sending Email using Spring Boot with <b>FreeMarker templates !!!</b></p>
                <p>Thanks</p>
            </td>
        </tr>
        <tr>
            <td bgcolor="#777777" style="padding: 30px 30px 30px 30px;">
                <p>${signature}</p>
                <p>${location}</p>
            </td>
        </tr>
    </table>

</body>
</html>