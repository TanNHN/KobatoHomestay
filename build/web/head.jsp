<%-- 
    Document   : index
    Created on : Nov 28, 2019, 11:11:40 PM
    Author     : Tan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Kobato Homestay</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700|Work+Sans:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">



        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>

        <div class="site-wrap">

            <div class="site-mobile-menu">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div> <!-- .site-mobile-menu -->


            <div class="site-navbar-wrap js-site-navbar bg-white">

                <div class="container">
                    <div class="site-navbar bg-light">
                        <div class="py-1">
                            <div class="row align-items-center">
                                <div class="col-2">
                                    <h2 class="mb-0 site-logo"><a href="index.jsp">Kobato</a></h2>
                                </div>
                                <div class="col-10">
                                    <nav class="site-navigation text-right" role="navigation">
                                        <div class="container">

                                            <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                                            <ul class="site-menu js-clone-nav d-none d-lg-block">
                                                <li>
                                                    <a href="index.jsp">Home</a>
                                                </li>
                                                <li class="has-children">
                                                    <a href="MainController?action=ShowAllRoom">Rooms</a>
                                                    <ul class="dropdown arrow-top">
                                                        <li><a href="MainController?action=ShowRoomFromCategory&txtRoomID=cr1">Single Room</a></li>
                                                        <li><a href="MainController?action=ShowRoomFromCategory&txtRoomID=cr2">Four people Room</a></li>
                                                        <li><a href="MainController?action=ShowRoomFromCategory&txtRoomID=cr3">Family Room</a></li>
                                                        <li><a href="MainController?action=ShowRoomFromCategory&txtRoomID=cr4">Deluxe Room</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="about.jsp">About</a></li>
                                                <li><a href="contact.jsp">Contact</a></li>
                                                    <c:if test="${sessionScope.USERNAME == null}" var="testLogin">
                                                    <li><a href="login.jsp">Login</a></li>
                                                    </c:if>
                                                <li class="has-children">
                                                    <c:if test="${!testLogin}">
                                                        <a href="MainController?action=ViewProfile">${sessionScope.USERNAME}</a>
                                                        <c:if test="${sessionScope.ROLE eq 'admin'}">
                                                            <ul class="dropdown arrow-top">
                                                                <li><a href="MainController?action=ViewProfile">My profile</a></li>
                                                                <li><a href="MainController?action=ShowAllBookingRequest">View Booking Request</a></li>
                                                                <li><a href="MainController?action=ShowAllBookedRoom">View Booked Room</a></li>
                                                                <li><a href="view_cart.jsp">View Cart</a></li>
                                                                <li><a href="search_user.jsp">Search for User</a></li>                                                                
                                                                <li><a href="MainController?action=ShowAllRoomToAdmin">Manage Room</a></li>
                                                                <li><a href="MainController?action=ShowMyRoom">My Room</a></li>
                                                                <li><a href="MainController?action=LogOut">Log out</a></li>
                                                            </ul>
                                                        </c:if>
                                                        <c:if test="${sessionScope.ROLE eq 'user'}">
                                                            <ul class="dropdown arrow-top">
                                                                <li><a href="MainController?action=ViewProfile">My Profile</a></li>
                                                                <li><a href="view_cart.jsp">View Cart</a></li>
                                                                <li><a href="MainController?action=ShowMyBooking">View your Booking</a></li>
                                                                <li><a href="MainController?action=ShowMyRoom">My Room</a></li>
                                                                <li><a href="MainController?action=LogOut">Log out</a></li>
                                                            </ul>
                                                        </c:if>
                                                    </c:if>
                                                </li>
                                            </ul>
                                        </div>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>