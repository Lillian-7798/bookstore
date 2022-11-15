import React from 'react';
import ReactDOM from 'react-dom';
import './css/bootstrap.min.css';
import './css/font-awesome.min.css';
import './css/owl.carousel.min.css';
import './css/animate.min.css';
import './css/jquery-ui.css';
import './css/slick.css';
import './css/chosen.min.css';
import './css/pe-icon-7-stroke.css';
import './css/magnific-popup.min.css';
import './css/jquery.scrollbar.min.css';
import './css/mobile-menu.css';
import './fonts/flaticon/flaticon.css';
import './css/style.css';

const data=[["new","The Left Hand of Darkness","3","65","45"],
["old","ender is the Night","4","85","55"],
["new","The Sound and the Fury","2","45","24"],
["old","Go Gray","3","55","40"],
["old","These Lovers Fled Away","5","105","55"],
["old","The Heart is a Lonely Hunter","1","32","16"],
["new","Where Angels Fear to Tread","4","43","25"],
["old","Jane Eyre","5","54","48"],
["old","The Red and the Black","4","63","45"],
["old","The Little Prince","5","45","35"],
["old","Reynard the Fox","3","62","30"],
["new","A Surrounded City","5","132","108"],];

class Books extends React.Compenet{
    constructor(props){
        super(props);
        this.state={
            data:this.props.booksinfor,
            sort_by: null,
            is_sort:false,
        };
    }
    render=()=>{
        return(
            <div>{this.rederBooks()}</div>                
        );
    };
    getSortBy() {
        var obj = document.getElementById("sort");
        var index = obj.selectedIndex;
        var te = obj.options[index].text;
        this.setState({ sort_by: te, is_sort: true });
    }
    renderABook (abook)  {
        return (
            <li className="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">
                <div class="product-inner equal-element">
                    <div class="product-top">{
                        function () {
                            if (abook[0] == "new") {
                                return (<div class="flash">
                                    <span class="onnew">
                                        <span class="text">
                                            new
                                        </span>
                                    </span>
                                </div>);
                            }
                        }
                    }
                    </div>
                    <div class="product-thumb">
                        <div class="thumb-inner">
                            <a href="#">
                                <img src="img/product-item-1.jpg" alt="img" />
                            </a>
                            <div class="thumb-group">
                                <div class="yith-wcwl-add-to-wishlist">
                                    <div class="yith-wcwl-add-button">
                                        <a href="#">Add to Wishlist</a>
                                    </div>
                                </div>
                                <a href="#" class="button quick-wiew-button">Quick View</a>
                                <div class="loop-form-add-to-cart">
                                    <button class="single_add_to_cart_button button">Add to cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <h5 class="product-name product_title">
                            <a href="#">{abook.slice(1,2)}</a>
                        </h5>
                        <div class="group-info">
                            <div class="stars-rating">
                                <div class="star-rating">
                                    <span class="star-3"></span>
                                </div>
                                <div class="count-star">
                                    {abook.slice(2,3)}
                                </div>
                            </div>
                            <div class="price">
                                <del>
                                    ${abook.slice(3,4)}
                                </del>
                                <ins>
                                    ${abook.slice(4,5)}
                                </ins>
                            </div>
                        </div>
                    </div>
                </div>
            </li>);
    }
    rederBooks=()=>{
        return(
            <ul class="row list-products auto-clear equal-container product-grid">
                {
                    function () {
                        if (this.state.is_sort==false||this.state.sort_by == "price: low to high" || this.state / sort_by == "popularity"||this.state.sort_by == "newness") {
                            if (this.state.sort_by == "price: Low to High") this.data.sort(function (a, b) { return a[4] - b[4] });
                            else if(this.state.sort_by == "popularity")this.data.sort(function (a, b) { return a[2] - b[2] });
                            else if(this.state.sort_by == "newness")this.data.sort(function(a,b){return a[0].localeCompare(b[0])});
                            return (
                                <div>{
                                    function () {
                                        var i = 0;
                                        while (i < 12) {renderABook(data[i]);i=i+1;}
                                    }}
                                </div>
                            );
                        }
                        else if(this.state.sort_by=="price: high to low"){
                            this.data.sort(function(a,b){return a[4]-b[4]});
                            return (
                                <div>{
                                    function(){
                                        var i=11;
                                        while(i>=0) {renderABook(data[i]);i=i-1;}
                                    }
                                }
                                </div>
                            );
                        }
                    }
                }
            </ul>
        );
    }
}

function Column(){
    getSortBy();
    return(
        ReactDOM.render(
            React.createElement(Books,{
                booksinfor:data
            }),
            document.getElementById("column")
        )
    );
}
export default Column;
// function test(){
//     return(
//         <div>hello</div>
//     ),
//     document.getElementById("column")
// }