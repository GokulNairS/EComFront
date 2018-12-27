<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
 <div class="row" style="margin: 2%">
  <div class="col-sm-5 ">
   <div>
    <img src="resources/productimage/${Product.productId}.jpg"
     width="300px" height="300px" />
   </div>
  </div>
  <div class="col-sm-7">
   <div class="card-body p-5">
    <h3 class="title mb-3">${Product.productName}</h3>
    <dl class="item-property">
     <dt>Description</dt>
     <dd>
      <p>${Product.productDesc}</p>
     </dd>
    </dl>
    <p class="price-detail-wrap">
     <span class="price h3 text-warning"> <span class="num">${Product.price}</span>
     </span>
    </p>
    <dl class="param param-feature">
     <dt>Delivery</dt>
     <dd>Free Shipping And COD</dd>
    </dl>
    <c:if test="${Product.quantity != 0 }">
     <label>Enter Quantity</label>
     <input type="number" min="1" name="upqty" id="upqty"
      class="text-center" value="1">
    </c:if>
    <br>
    <hr>
    <c:if test="${Product.quantity == 0 }">
     <span class="btn btn-primary btn-product ">Out of Stock</span>
    </c:if>
    <c:if test="${Product.quantity != 0 }">
     <a name="refreshcart" id="refreshcart" onclick='setURL()'
      value="${Product.productId}"
      class="btn btn-success btn-product"> <span
      class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
     </a>
    </c:if>
    <a href="productdisplay" class="btn btn-success btn-product">BACK</a>
   </div>
  </div>
 </div>
</div>
