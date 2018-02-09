<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" xml:lang="en-gb"
	lang="en-gb">
	<head>
	
	<title>Nouveau Post</title>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
	<link rel="stylesheet" href="fichiers/style.css" type="text/css" />
	
	</head>
	<body class="ltr">
	
		<div id="wrapcentre">
	
	
	
			<div id="pagecontent">
	
				<%@ include file="bandeau.jspf" %>
				<br clear="all" />
			</div>
			<form action="" method="post">
				
				<textarea name="messagePost" rows="5" cols="60" placeholder="Tapez votre texte ici" style="width:100%;"></textarea>
				<input type="submit" value="Valider" class="btnmain">
			</form>
		
			<br clear="all" />
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
