import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Categories from '../Categories/categories';
import Products from '../Products/ProductList/products';
import ProductAdd from '../Products/ProductAdd/ProductAdd'
import Header from '../Header/header';
import Manufacturers from "../Manufacturers/manufacturers"
import GamingEShopService from "../../repository/gamingEShopRepository";
import gamingEShopRepository from "../../repository/gamingEShopRepository";
import ProductEdit from "../Products/ProductEdit/ProductEdit";
import Login from "../Login/login";
import CategoryAdd from "../Categories/CategoryAdd/CategoryAdd";
import ManufacturerAdd from "../Manufacturers/ManufacturerAdd/ManufacturerAdd";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            manufacturers: [],
            products: [],
            categories: [],
            selectedProduct: {}
        }
    }

    render() {
        return(
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/manufacturers"} exact element={
                                <Manufacturers manufacturers={this.state.manufacturers}/>}/>

                            <Route path={"/categories"} exact element={
                                <Categories categories={this.state.categories}/>}/>

                            <Route path={"/products/add"} exact element={
                                <ProductAdd categories={this.state.categories}
                                            manufacturers={this.state.manufacturers}
                                            onAddProduct={this.addProduct}/>}/>

                            <Route path={"/categories/add"} exact element={
                                <CategoryAdd onAddCategory={this.addCategory}/>
                            }/>

                            <Route path={"/manufacturers/add"} exact element={
                                <ManufacturerAdd onAddManufacturer={this.addManufacturer}/>
                            }/>


                            <Route path={"/products/edit/:id"} exact element={
                                <ProductEdit categories={this.state.categories}
                                             manufacturers={this.state.manufacturers}
                                            onEditProduct={this.editProduct}
                                            product={this.state.selectedProduct}
                                />}/>


                            <Route path={"/products"} exact element={
                                <Products products={this.state.products}
                                          onDelete={this.deleteProduct}
                                          onEdit={this.getProduct}
                                />}/>

                            <Route path={"/login"} exact element={
                                <Login onLogin={this.fetchData}/>}/>

                            <Route to={"/products"}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.fetchData()
    }

    fetchData= () => {
        this.loadManufacturers();
        this.loadProducts();
        this.loadCategories();
    }

    loadManufacturers = () => {
        GamingEShopService.fetchManufacturers()
            .then((data) => {
                console.log(data);
                this.setState({
                    manufacturers: data.data
                })
            });

    }

    loadCategories = () => {
        GamingEShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });

    }

    loadProducts = () => {
        GamingEShopService.fetchProducts()
            .then((data) => {
                this.setState({
                    products: data.data
                })
            });

    }

    deleteProduct = (id) => {
        GamingEShopService.deleteProduct(id)
            .then(() => {
                this.loadProducts();
            });
    }

    addProduct = (name, price, quantity, category, manufacturer) => {
        gamingEShopRepository.addProduct(name, price, quantity, category, manufacturer)
            .then(() => {
                this.loadProducts();
            });
    }

    addCategory = (name, description) => {
        gamingEShopRepository.addCategory(name, description)
            .then(() => {
                this.loadCategories();
            });
    }

    addManufacturer = (name, address) => {
        gamingEShopRepository.addManufacturer(name, address)
            .then(() => {
                this.loadManufacturers();
            });
    }

    getProduct = (id) => {
        gamingEShopRepository.getProduct(id)
            .then((data) => {
                this.setState({
                    selectedProduct: data.data
                })
            })
    }

    editProduct = (id, name, price, quantity, category, manufacturer) => {
        gamingEShopRepository.editProduct(id, name, price, quantity, category, manufacturer)
            .then(() => {
                this.loadProducts()
            })
    }
}

export default App;
