<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<!-- Mirrored from resources/index-hot-shop-home.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 11 Jan 2020 07:45:17 GMT -->
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
 <%@include file="userheader.jsp" %>
  <!-- Start main-content -->
  
 

    <section>
      <div class="container pb-0">
        <div class="section-title text-center mb-30">
          <div class="row">
            <div class="col-md-12">
              <h2 class="mt-0 mb-5">New Collection</h2>
              <p class="font-16 mt-0">See what new products are available in online shop</p>
            </div>
          </div>
        </div>
        <div class="row">               
                  <div class="col-sm-4">
                    <div class="form-group">
                      
                      <select name="sort" class="form-control">
                      	
                        <option disabled selected>SORT BY</option>
                        <option value="Price">Price</option>
                        <option value="Newly Added">Newly Added</option>
                       
                      </select>
                    </div>
                  </div>
                
       <div class="col-sm-4" id="search">
        <div class="widget">
                  
                  <div class="search-form">
                    <form>
                      <div class="input-group">
                        <input type="text" placeholder="Click to Search" class="form-control search-input">
                        <span class="input-group-btn">
                        <button type="submit" class="btn search-button"><i class="fa fa-search"></i></button>
                        </span>
                      </div>
                    </form>
                  </div>
                </div>
                </div>
                <div class="col-sm-4">
                    <div class="form-group">
                      
                      <select name="ngo" class="form-control">
                      	
                        <option disabled selected>CHOOSE NGO</option>
                        <option value="name">NGO name</option>
                        <option value="name">NGO name</option>
                       
                      </select>
                    </div>
                  </div>
                
                </div>
        <div class="row multi-row-clearfix">
          <div class="col-md-12">
            <div class="products">
              <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                    
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
               <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                    
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                   
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
               <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                   
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                   
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                   
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                   
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
               <div class="col-sm-6 col-md-4 col-lg-3 mb-30">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/purse.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="cart.jsp" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="productdetails.jsp" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Purse</h5></a>
                   
                    <div class="price"><del><span class="amount">Rs500.00</span></del><ins><span class="amount">Rs400.00</span></ins></div>
                  </div>
                </div>
              </div>
             </div>
          </div>
        </div>
      </div>
    </section>

        <!-- Section: Shop  -->
    <section id="shop">
      <div class="container pb-30">
        <div class="section-title text-center mb-30">
          <div class="row">
            <div class="col-md-12">
            <nav>
                      <ul class="pagination theme-colored">
                        <li> <a href="#" aria-label="Previous"> <span aria-hidden="true">«</span> </a> </li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">...</a></li>
                        <li> <a href="#" aria-label="Next"> <span aria-hidden="true">»</span> </a> </li>
                      </ul>
                    </nav>
              <h2 class="mt-0 mb-5">Best Selling Products</h2>
              <h4>See our all time best products in online store</h4>
            </div>
          </div>
        </div>
        <div class="row multi-row-clearfix">
          <div class="col-md-12">
            <div class="products owl-carousel-4col">
              <div class="item">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/products/1.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-cart.html" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-product-details.html" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Shirt</h5></a>
                   
                    <div class="price"><del><span class="amount">$110.00</span></del><ins><span class="amount">$90.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="product">
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/products/2.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-cart.html" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-product-details.html" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">T-Shirt</h5></a>
                   
                    <div class="price"><ins><span class="amount">$480.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/products/3.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-cart.html" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-product-details.html" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">White T-Shirt</h5></a>
                   
                    <div class="price"><del><span class="amount">$70.00</span></del><ins><span class="amount">$55.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="product">
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/products/4.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-cart.html" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-product-details.html" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Blue-Shirt</h5></a>
                   
                    <div class="price"><ins><span class="amount">$185.00</span></ins></div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="product">
                  <span class="tag-sale">Sale!</span>
                  <div class="product-thumb"> 
                    <img alt="" src="/unfoldhappiness_volunteer/resources/images/products/5.jpg" class="img-responsive img-fullwidth">
                    <div class="overlay">
                      <div class="btn-add-to-cart-wrapper">
                        <a class="btn btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-cart.html" target="_blank">Add To Cart</a>
                      </div>
                      <div class="btn-product-view-details">
                        <a class="btn btn-default btn-theme-colored btn-sm btn-flat pl-20 pr-20 btn-add-to-cart text-uppercase font-weight-700" href="shop-product-details.html" target="_blank">View detail</a>
                      </div>
                    </div>
                  </div>
                  <div class="product-details text-center">
                    <a href="#"><h5 class="product-title">Blue-Jeans</h5></a>
                   
                    <div class="price"><del><span class="amount">$220.00</span></del><ins><span class="amount">$210.00</span></ins></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Divider: Call To Action -->
   
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

<!-- SLIDER REVOLUTION 5.0 EXTENSIONS  
      (Load Extensions only on Local File Systems ! 
       The following part can be removed on Server for On Demand Loading) -->
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.actions.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.carousel.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.kenburn.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.migration.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.navigation.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.parallax.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.slideanims.min.js"></script>
<script type="text/javascript" src="/unfoldhappiness_volunteer/resources/js/revolution-slider/js/extensions/revolution.extension.video.min.js"></script>

</body>
<style>
#search
{
	align:center;
}
</style>
<!-- Mirrored from resources/index-hot-shop-home.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 11 Jan 2020 07:45:37 GMT -->
</html>