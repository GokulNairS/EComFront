 <style>
.backdrop {
    background-size: contain;
    background-position: center;
    margin: auto;
    margin-top: 20px;
    width: 75vw;
}
.backdrop.shibuya {
    background-image: url("https://oneclassblog.com/wp-content/uploads/2018/01/geo-sports-banner-cropped-size21.png");
}
.text { 
    color: white;
    border: 4px white solid;
    mix-blend-mode: multiply;
    font: bolder 10vw monospace;
    text-align: center;
    margin: 0;
    cursor: pointer;
    transition: text-indent 0.5s;
}

.text:hover {
    text-indent: 5px;
    transition: text-indent 0.5s;
}

.text:hover::before {
    display: inline-block;
   content: ";-) ";
} 

.text.shibuya {
    font-family: "Bungee Shade", cursive;
    background-color: rgba(2, 22, 48, 1);
    outline: 4px rgba(2, 22, 48, 1) solid;
    font-size: 6vw;
}
</style>
<body>
<nav class="navbar">
<div class="backdrop shibuya">
    <p class="text shibuya">FLORIC</p>
</div>
</nav>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
     <li ><a href="home">FLORIC</a></li>
     <li ><a href="aboutus">About Us</a></li>
       <li ><a href="contactus">Contact Us</a></li>
         <li ><a href="category">Category</a></li>
           <li ><a href="product">Product</a></li>
    <ul class="nav navbar-nav navbar-right">
 <li ><a href="register">Register</a></li>
 
 
 </ul>
     
     
      
      
      
    </div>
  </div>
</nav>


