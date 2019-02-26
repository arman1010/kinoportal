<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 26.02.2019
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

    <title>Movie Review</title>

    <!-- Loading third party fonts -->
    <link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
    <link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Loading main css file -->
    <link rel="stylesheet" href="/css/style.css">

    <!--[if lt IE 9]>
    <script src="js/ie-support/html5.js"></script>
    <script src="js/ie-support/respond.js"></script>
    <![endif]-->

</head>


<body>


<div id="site-content">
    <header class="site-header">
        <div class="container">
            <a href="home.jsp" id="branding">
                <img src="images/logo.png" alt="" class="logo">
                <div class="logo-copy">
                    <h1 class="site-title">Company Name</h1>
                    <small class="site-description">Tagline goes here</small>
                </div>
            </a> <!-- #branding -->

            <div class="main-navigation">
                <button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
                <ul class="menu">
                    <li class="menu-item current-menu-item"><a href="home.jsp">Home</a></li>
                    <li class="menu-item"><a href="review.html">Movie reviews</a></li>
                </ul> <!-- .menu -->

                <form action="#" class="search-form">
                    <input type="text" placeholder="Search...">
                    <button><i class="fa fa-search"></i></button>
                </form>
            </div> <!-- .main-navigation -->

            <div class="mobile-navigation"></div>
        </div>
    </header>
    <main class="main-content">
        <div class="container">
            <div class="page">
                <div class="row" style="height: 40px;">
                    <div class="col-md-9">
                        <div class="slider">
                            <ul class="slides">
                                <C:forEach var="allKinos" items="${requestScope.get('allKinos')}">
                                    <li style="height: 700px;"><a href="/movieDetail?id=${allKinos.id}"><img src="/getImage?picName=${allKinos.picUrl}"
                                                                              alt="Slide 1"></a>
                                    </li>
                                </C:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3">

                    </div> <!-- .row -->
                </div>
                <%--<div class="row">--%>
                <%--<div class="col-sm-6 col-md-3">--%>
                <%--<div class="latest-movie">--%>
                <%--<c:forEach var="allKinos" items="${requestScope.get('allKinos')}">--%>
                <%--<a href="#"><img src="/getImage?picName=${allKinos.picUrl}" alt="Movie 3"></a>--%>
                <%--<h2>${allKinos.name}</h2>--%>
                <%--</c:forEach>--%>
                <%--</div>--%>
                <%--</div> <!-- .row -->--%>
                <%--</div>--%>
                <div class="row">
                    <c:forEach var="allKinos" items="${requestScope.get('allKinos')}">
                        <div class="col-sm-6 col-md-3">
                            <div class="latest-movie">
                                <a href="/movieDetail?id=${allKinos.id}"><img src="/getImage?picName=${allKinos.picUrl}" alt="Movie 3"></a>
                                <h2>${allKinos.name}</h2>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-4">
                <h2 class="section-title">October premiere</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
                <ul class="movie-schedule">
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                </ul> <!-- .movie-schedule -->
            </div>
            <div class="col-md-4">
                <h2 class="section-title">November premiere</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
                <ul class="movie-schedule">
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                </ul> <!-- .movie-schedule -->
            </div>
            <div class="col-md-4">
                <h2 class="section-title">October premiere</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
                <ul class="movie-schedule">
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                    <li>
                        <div class="date">16/12</div>
                        <h2 class="entry-title"><a href="#">Perspiciatis unde omnis</a></h2>
                    </li>
                </ul> <!-- .movie-schedule -->
            </div>
        </div><!-- .container -->
    </main>

</div>
<!-- Default snippet for navigation -->


<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/plugins.js"></script>
<script src="js/app.js"></script>
<footer class="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">About Us</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia tempore vitae mollitia nesciunt saepe cupiditate</p>
                </div>
            </div>
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Recent Review</h3>
                    <ul class="no-bullet">
                        <li><a href="#">Lorem ipsum dolor</a></li>
                        <li><a href="#">Sit amet consecture</a></li>
                        <li><a href="#">Dolorem respequem</a></li>
                        <li><a href="#">Invenore veritae</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Help Center</h3>
                    <ul class="no-bullet">
                        <li><a href="#">Lorem ipsum dolor</a></li>
                        <li><a href="#">Sit amet consecture</a></li>
                        <li><a href="#">Dolorem respequem</a></li>
                        <li><a href="#">Invenore veritae</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Join Us</h3>
                    <ul class="no-bullet">
                        <li><a href="#">Lorem ipsum dolor</a></li>
                        <li><a href="#">Sit amet consecture</a></li>
                        <li><a href="#">Dolorem respequem</a></li>
                        <li><a href="#">Invenore veritae</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Social Media</h3>
                    <ul class="no-bullet">
                        <li><a href="#">Facebook</a></li>
                        <li><a href="#">Twitter</a></li>
                        <li><a href="#">Google+</a></li>
                        <li><a href="#">Pinterest</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <div class="widget">
                    <h3 class="widget-title">Newsletter</h3>
                    <form action="#" class="subscribe-form">
                        <input type="text" placeholder="Email Address">
                    </form>
                </div>
            </div>
        </div> <!-- .row -->

        <div class="colophon">Copyright 2014 Company name, Designed by Themezy. All rights reserved</div>
    </div> <!-- .container -->

</footer>
</div>
<!-- Default snippet for navigation -->



<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/plugins.js"></script>
<script src="js/app.js"></script>

</body>

</body>
</html>