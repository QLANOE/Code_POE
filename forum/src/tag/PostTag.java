package tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import utilisateurs.Post;

public class PostTag extends SimpleTagSupport {

	private Post post;

	public void doTag() throws IOException {

		JspWriter out = getJspContext().getOut();
		out.println("<table class=\"tablebg\" cellspacing=\"1\" width=\"100%\">\r\n" + "					<tbody>\r\n"
				+ "						<tr class=\"row2\">\r\n" + "	\r\n"
				+ "							<td valign=\"middle\" align=\"center\"><b class=\"postauthor\">"
				+ post.getUser().getName() + "</b>\r\n" + "							</td>\r\n"
				+ "							<td width=\"100%\" height=\"25\">\r\n"
				+ "								<table cellspacing=\"0\" width=\"100%\">\r\n"
				+ "									<tbody>\r\n" + "										<tr>\r\n"
				+ "	\r\n" + "											<td class=\"gensmall\" width=\"100%\">\r\n"
				+ "												<div style=\"float: left;\">&nbsp;\r\n"
				+ "													<b>Fil de discussion :</b>"
				+ post.getThread().getTitre() + "\r\n" + "												</div>\r\n"
				+ "												<div style=\"float: right;\">\r\n"
				+ "													<b>Posted:</b>" + post.getDate() + "\r\n"
				+ "												</div>\r\n"
				+ "											</td>\r\n"
				+ "										</tr>\r\n" + "									</tbody>\r\n"
				+ "								</table>\r\n" + "							</td>\r\n"
				+ "						</tr>\r\n" + "					</tbody>\r\n" + "	\r\n"
				+ "					<tr class=\"row2\">\r\n" + "	\r\n"
				+ "						<td class=\"profile\" valign=\"top\">\r\n"
				+ "							<table cellspacing=\"4\" align=\"center\" width=\"150\">\r\n" + "	\r\n"
				+ "							</table> <span class=\"postdetails\"> <b>Posts:</b> 24\r\n"
				+ "						</span>\r\n" + "	\r\n" + "						</td>\r\n"
				+ "						<td valign=\"top\">\r\n"
				+ "							<table cellspacing=\"5\" width=\"100%\">\r\n"
				+ "								<tbody>\r\n" + "									<tr>\r\n"
				+ "										<td>\r\n"
				+ "											<div class=\"postbody\">" + post.getMessage() + "</div>\r\n"
				+ "											<br clear=\"all\" /><br />\r\n"
				+ "											<table cellspacing=\"0\" width=\"100%\">\r\n"
				+ "												<tbody>\r\n"
				+ "													<tr valign=\"middle\">\r\n"
				+ "														<td class=\"gensmall\" align=\"right\"></td>\r\n"
				+ "													</tr>\r\n"
				+ "												</tbody>\r\n"
				+ "											</table>\r\n"
				+ "										</td>\r\n" + "									</tr>\r\n"
				+ "								</tbody>\r\n" + "							</table>\r\n"
				+ "						</td>\r\n" + "					</tr>\r\n" + "	\r\n"
				+ "					<tr>\r\n"
				+ "						<td class=\"spacer\" colspan=\"2\" height=\"1\"><img src=\"fichiers/spacer.gif\" alt=\"\" width=\"1\" height=\"1\" /></td>\r\n"
				+ "					</tr>\r\n" + "				</table>");

	}

}
