<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire d'inscription</title>
<link rel="stylesheet" href="fichiers/style.css" type="text/css" />
</head>
<body class="ltr">

	<div id="wrapcentre">

		<br style="clear: both;" />

		<table class="tablebg" style="margin-top: 5px;" cellspacing="1"
			cellpadding="0" width="100%">
			<tbody>
				<tr>
					<td class="row1">
						<p class="breadcrumbs">
							<a href="#">Board index</a>
						</p>
					</td>
				</tr>
			</tbody>
		</table>
		<br />

		<form action="#" method="post">

			<table class="tablebg" cellspacing="1" width="100%">
				<tbody>
					<tr>
						<th colspan="2">Choissisez vos identifiants</th>
					</tr>

					<tr>
						<td class="row2">

							<table style="width: 100%;" cellspacing="1" cellpadding="4"
								align="center">
								<tbody>
									<tr>
										<td valign="top"><b class="gensmall">Login :</b></td>
										<td><input class="post" name="username" size="25"
											tabindex="1" type="text" /></td>
									</tr>
									<tr>
										<td valign="top"><b class="gensmall">Mot de passe:</b></td>
										<td><input class="post" name="password" size="25"
											tabindex="2" type="password" /></td>
									</tr>
									<tr>
										<td valign="top"><b class="gensmall">Email:</b></td>
										<td><input class="post" name="email" size="25"
											tabindex="2" type="text" /></td>
									</tr>

								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td valign="top"><b class="gensmall"><%=request.getAttribute("msg") + ""%>
						</b></td>
					</tr>

					<tr>
						<td class="cat" colspan="2" align="center"><input
							name="login" class="btnmain" value="Inscription" tabindex="5"
							type="submit" /></td>
					</tr>
				</tbody>
			</table>

		</form>

		<table class="tablebg" style="margin-top: 5px;" cellspacing="1"
			cellpadding="0" width="100%">
			<tbody>
				<tr>
					<td class="row1">
						<p class="breadcrumbs">Index du forum</p>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>