<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<h1>Supervisor Page</h1>
<%
scid=(String)session.getAttribute("scid");
%>
<div id="welcome">
<h2><span>Welcome:::<strong><font color='Red'><%= scid %></font></strong></span></h2> 
</div>
<p>Only Supervisor have access to this page.</p>
<p class="muted small">
Curabitur quis libero elit, dapibus iaculis nisl. Nullam quis velit eget odio 
adipiscing tristique non sed ligula. In auctor diam eget nisl condimentum laoreet..
Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh 
euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad 
minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut 
aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in 
vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis 
at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum 
zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum 
soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat 
facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis 
qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius 
quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur 
mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc 
putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta 
decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, 
fiant sollemnes in futurum.
</p>