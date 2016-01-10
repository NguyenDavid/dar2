<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>BreakFirst Game - Paris</title>
  <meta name="description" content="free website template" />
  <meta name="keywords" content="enter your keywords here" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=9" />
  <link rel="stylesheet" type="text/css" href="/web-resources/css/style.css" />
  <link rel="stylesheet" type="text/css" href="/web-resources/css/style2.css" media="screen" />
  <!-- remplacer dans href : "${pageContext.request.contextPath}/resources..." media="screen" -->
  
  <link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.css"/>'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href='<c:url value="/web-resources/css/custom.css"/>'>
  
  <script type="text/javascript" src="/web-resources/js/jquery.min.js"></script>
  <script type="text/javascript" src="/web-resources/js/image_slide.js"></script>
  <script type="text/javascript" src="/web-resources/js/script.js"></script>
  <script type="text/javascript" src="/web-resources/js/login.js"></script>
  <script type="text/javascript" src="/web-resources/js/meteo2.js"></script>


		<title>Tutoriel Google Maps</title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<!-- Elément Google Maps indiquant que la carte doit être affiché en plein écran et
		qu'elle ne peut pas être redimensionnée par l'utilisateur -->
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<!-- Inclusion de l'API Google MAPS -->
		<!-- Le paramètre "sensor" indique si cette application utilise détecteur pour déterminer la position de l'utilisateur -->
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<script type="text/javascript">


			function initialiser() {
				var latlng = new google.maps.LatLng(48.8464111, 2.3548468);
				//objet contenant des propriétés avec des identificateurs prédéfinis dans Google Maps permettant
				//de définir des options d'affichage de notre carte
				var options = {
					center: latlng,
					zoom: 19,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
				
				//constructeur de la carte qui prend en paramêtre le conteneur HTML
				//dans lequel la carte doit s'afficher et les options
				var carte = new google.maps.Map(document.getElementById("carte"), options);
			}


			function map(){
				if(document.getElementById("carte").style.height > "100px"){
					var height = document.getElementById("carte").style.height;
					document.getElementById("carte").style.height = "0px";
				}else{
					document.getElementById("carte").style.height = "420px";
					initialiser();
				}
			}
	
		</script>

</head>

<body onload="showMeteo();initialiser();map();">
	<div id="content-wrapper">
		<div id="page-inner">
			<div class="col-md-4 col-centered margin-top-xl">
				<div class="panel panel-back noti-box">
					<div class="input-group margin-bottom-lg">
						<span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
						<form:input path="email" class="form-control" placeholder="Adresse e-mail (Nom d'utilisateur)"></form:input>
					</div>
				</div>
			</div>
		</div>
	</div>




  <div id="main">
    <div id="header">
	  <div id="banner">
	    <div id="welcome">
</br>
	      <h1>BreakFirst Game</h1>
</br>
	    </div><!--close welcome-->
	    <div id="welcome_slogan">
	      <h1>Paris</h1>
	    </div><!--close welcome_slogan-->
	  </div><!--close banner-->
    </div><!--close header-->

	<div id="menubar">
      <ul id="menu">
	        <li><a href="index.jsp">Home</a></li>
	        <li><a href="login.jsp">Login</a></li>
        <li><a href="register.jsp">Register</a></li>
        <li><a href="calendrier.jsp">Mon Calendrier</a></li>
	<li><a href="reseau.jsp">R&eacuteseau</a></li>
        <li><a href="contact.jsp">Contactez Nous</a></li>
      </ul>
    </div><!--close menubar-->	
    
	<div id="site_content">		

	  <div class="sidebar_container">       
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Coffee Break</h2>
            <p>Trouvez un point de rendez-vous pour vous retrouver entre amis.</p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->     		
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Latest Update</h2>
            <h3>March 2013</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim.</p>         
		  </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
		<div class="sidebar">
          <div class="sidebar_item">
            <h3>February 2013</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim.</p>         
		  </div><!--close sidebar_item--> 
        </div><!--close sidebar-->  
		<div class="sidebar">
          <div class="sidebar_item">
            <h3>January 2013</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim.</p>         
		  </div><!--close sidebar_item--> 
        </div><!--close sidebar-->  		
        <div class="sidebar">
          <div class="sidebar_item">
            <h2>Contact</h2>
            <p> Emails: </p>
            <p><a href="mailto:info@youremail.co.uk">email1</a></p>
            <p><a href="mailto:info@youremail.co.uk">email2</a></p>
            <p><a href="mailto:camille.guillard@etu.upmc.fr">camille.guillard@etu.upmc.fr</a></p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
       </div><!--close sidebar_container-->	
	
	  <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="680" height="250" src="/resources/assets/paris2.jpg" alt="&quot;Choose your destination&quot;" onclick="bonjour();" /></li>
          <div id = "meteo">





</div>
        </ul>
      </div>	  	 
	 
	  <div id="content">
        <div class="content_item">
		  <h1>Mon Calendrier</h1> 


	
		 <p><a href=# id="map" onclick="map();">Activer Google Maps</a></p>

	  <div id="carte" style="width:650px; height:420px;"></div>	 



<br>




          <div class="content_container">
		    <p>
<div id="rdv">
<h2>Mes rendez-vous:</h2>



</div>

</p>          

<br><br><br><br>

<h3>Ajouter rendez-vous:</h3>
<br>

<form name="loginForm" method="get" action="ajouter">

<label for="lieu" >Titre de l'&eacutev&egravenement :</label> <input type="text" name="lieu" id="lieu" size="30" maxlength="30" /> <br><br>

<label for="lieu" >Lieu :</label> <input type="text" name="lieu" id="lieu" size="30" maxlength="30" /> <br><br>

<label for="date" >Date :</label> <input type="text" size="2" name="jour" id="jour" maxlength="2" placeholder=" jj" /> <input type="text" size="2" name="mois" id="mois" maxlength="2" placeholder="mm" /> <input type="text" size="4" name="annee" id="annee" maxlength="4" placeholder=" aaaa" /> (jj/mm/aaaa)  <br><br>

<label for="heure" >Heure du rendez-vous :</label> <input type="text" name="heure" id="heure" size="1" maxlength="2" placeholder=" h"/> h <input type="text" name="minute" id="minute" size="1" maxlength="2" placeholder=" m"/> m <br><br>

<label for="duree" >Dur&eacutee :</label> <input type="text" name="duree" id="duree" size="1" maxlength="9"/> heure(s)<br><br>

<input type="hidden" name="secret" value="<secret per-request ID>"/>

</form>

<br>

		  	<div class="button_small_ajouter">
		      <a id="rdv" href="#" onclick="ajouter();">Ajouter un nouveau Rendez-vous</a>


		    </div><!--close button_small-->		  
		  </div><!--close content_container-->			  
		</div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content--> 
    
	<div id="content_bottom">
	  <div class="content_bottom_container_box">
		<h4>Latest Blog Post</h4>
	    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
		<div class="readmore">
		  <a href="#">Read more</a>
		</div><!--close readmore-->
	  </div><!--close content_bottom_container_box-->
      <div class="content_bottom_container_box">
       <h4>Latest News</h4>
	    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
	    <div class="readmore">
		  <a href="#">Read more</a>
		</div><!--close readmore-->
	  </div><!--close content_bottom_container_box-->
      <div class="content_bottom_container_boxl">
		<h4>Latest Projects</h4>
	    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
	    <div class="readmore">
		  <a href="#">Read more</a>
		</div><!--close readmore-->	  
	  </div><!--close content_bottom_container_box1-->      
	  <br style="clear:both"/>
    </div><!--close content_bottom-->   
 
  </div><!--close main-->
  
  <div id="footer">
	  <a href="http://validator.w3.org/check?uri=referer">Valid XHTML</a> | <a href="http://fotogrph.com/">Images</a> | <a href="http://www.heartinternet.co.uk/vps/">Virtual Server</a> | website template by <a href="http://www.araynordesign.co.uk">ARaynorDesign</a>
  </div><!--close footer-->  
  
</body>
</html>
