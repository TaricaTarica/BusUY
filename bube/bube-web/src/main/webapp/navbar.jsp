 <% HttpSession sesion = request.getSession(); %>
 <nav class="orange darken-4">
   <div class="nav-wrapper">
     <a href="/bube-web/index.jsp" class="brand-logo">
     	<i class="large material-icons">directions_bus</i>
     	Busuy
     </a>
     <ul id="nav-mobile" class="right hide-on-med-and-down">
     <%if(sesion.getAttribute("administrador") != null){ %>
       <li><a href="/bube-web/Logout"><i class="material-icons">exit_to_app</i></a></li>
     <%} %>
     </ul>
   </div>
 </nav>