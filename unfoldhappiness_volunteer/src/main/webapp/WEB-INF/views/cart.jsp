<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<!-- Mirrored from resources/shop-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 11 Jan 2020 07:50:01 GMT -->
<head>

<%@include file="core.jsp" %></head>
<body class="">
<div id="wrapper" class="clearfix">
  <!-- preloader -->
  <div id="preloader">
    <div id="spinner">
      <div class="preloader-dot-loading">
        <div class="cssload-loading"><i></i><i></i><i></i><i></i></div>
      </div>
    </div>
    <div id="disable-preloader" class="btn btn-default btn-sm">Disable Preloader</div>
  </div>
  
  <!-- Header -->
  
  
  <!-- Start main-content -->
  <div class="main-content">
    <!-- Section: inner-header -->
    <section class="inner-header divider parallax layer-overlay overlay-white-8" data-bg-img="/unfoldhappiness_volunteer/resources/images/bg/bg6.jpg">
      <div class="container pt-60 pb-60">
        <!-- Section Content -->
        <div class="section-content">
          <div class="row">
            <div class="col-md-12 text-center">
              <h2 class="title">Shop Cart</h2>
              
            </div>
          </div>
        </div>
      </div>
    </section>

    <section>
      <div class="container">
        <div class="section-content">
          <div class="row">
            <div class="col-md-12">
              <div class="table-responsive">
                <table class="table table-striped table-bordered tbl-shopping-cart">
                  <thead>
                    <tr>
                      <th></th>
                      <th>Photo</th>
                      <th>Product Name</th>
                      <th>Price</th>
                      <th>Quantity</th>
                      <th>Total</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr class="cart_item">
                      <td class="product-remove"><a title="Remove this item" class="remove" href="#">×</a></td>
                      <td class="product-thumbnail"><a href="#"><img alt="member" src="/unfoldhappiness_volunteer/resources/images/purse.jpg"></a></td>
                      <td class="product-name"><a href="#">Purse</a>
                        
                      <td class="product-price"><span class="amount">Rs400.00</span></td>
                      <td class="product-quantity"><div class="quantity buttons_added">
                          <input type="button" class="minus" value="-">
                          <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                          <input type="button" class="plus" value="+">
                        </div></td>
                      <td class="product-subtotal"><span class="amount">Rs400.00</span></td>
                    </tr>
                    <tr class="cart_item">
                      <td class="product-remove"><a title="Remove this item" class="remove" href="#">×</a></td>
                      <td class="product-thumbnail"><a href="#"><img alt="member" src="/unfoldhappiness_volunteer/resources/images/purse.jpg"></a></td>
                      <td class="product-name"><a href="#">Purse</a>
                        
                      <td class="product-price"><span class="amount">Rs400.00</span></td>
                      <td class="product-quantity"><div class="quantity buttons_added">
                          <input type="button" class="minus" value="-">
                          <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                          <input type="button" class="plus" value="+">
                        </div></td>
                      <td class="product-subtotal"><span class="amount">Rs400.00</span></td>
                    </tr>
                    <tr class="cart_item">
                      <td class="product-remove"><a title="Remove this item" class="remove" href="#">×</a></td>
                      <td class="product-thumbnail"><a href="#"><img alt="member" src="/unfoldhappiness_volunteer/resources/images/purse.jpg"></a></td>
                      <td class="product-name"><a href="#">Purse</a>
                        
                      <td class="product-price"><span class="amount">Rs400.00</span></td>
                      <td class="product-quantity"><div class="quantity buttons_added">
                          <input type="button" class="minus" value="-">
                          <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                          <input type="button" class="plus" value="+">
                        </div></td>
                      <td class="product-subtotal"><span class="amount">Rs400.00</span></td>
                    </tr>
                    <tr class="cart_item">
                      <td colspan="3"><div class="coupon">
                          <label for="cart-coupon">Coupon: </label>
                          <input id="cart-coupon" type="text" placeholder="Coupon code" value="" name="coupon_code">
                          <button type="button" class="btn">Apply Coupon</button>
                        </div></td>
                      <td colspan="2">&nbsp;</td>
                      <td><button type="button" class="btn">Update Cart</button></td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="col-md-12 mt-30">
              <div class="row">
                
                <div class="col-md-6">
                  <h4>Cart Totals</h4>
                  <table class="table table-bordered">
                    <tbody>
                      <tr>
                        <td>Cart Subtotal</td>
                        <td>$180.00</td>
                      </tr>
                      <tr>
                        <td>Shipping and Handling</td>
                        <td>$70.00</td>
                      </tr>
                      <tr>
                        <td>Order Total</td>
                        <td>$250.00</td>
                      </tr>
                    </tbody>
                  </table>
                  <a class="btn btn-default" href="checkout.jsp">Proceed to Checkout</a> </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <!-- end main-content -->


  <!-- Footer -->
  <footer id="footer" class="footer bg-black-222">
      <div class="row mt-10">
        
        <%@include file="userfooter.jsp" %>
      </div>
    </div>
      </footer>
  
    <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
</div>
<!-- end wrapper -->

<!-- Footer Scripts -->
<!-- JS | Custom script for all pages -->
<script src="/unfoldhappiness_volunteer/resources/js/custom.js"></script>

</body>

<!-- Mirrored from resources/shop-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 11 Jan 2020 07:50:01 GMT -->
</html>