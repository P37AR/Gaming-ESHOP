import axios from '../custom-axios/axios';

const GamingEShopService = {
    fetchManufacturers: () => {
        return axios.get("/manufacturers");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchProducts: () => {
        return axios.get("/products");
    },
    deleteProduct: (id) => {
        return axios.delete(`/products/delete/${id}`)
    },
    addProduct: (name, price, quantity, category, manufacturer) => {
        return axios.post("/products/add", {
            "name" : name,
            "price" : price,
            "quantity" : quantity,
            "category" : category,
            "manufacturer" : manufacturer
        });
    },
    addManufacturer: (name, address) => {
        return axios.post("/manufacturers/add", {
            "name": name,
            "address": address
        })
    },
    addCategory: (name, description) => {
        return axios.post("/categories/add", {
            "name": name,
            "description": description
        })
    },
    editProduct: (id, name, price, quantity, category, manufacturer) => {
        return axios.put(`/products/edit/${id}`, {
            "name" : name,
            "price" : price,
            "quantity" : quantity,
            "category" : category,
            "manufacturer" : manufacturer
        });
    },
    getProduct: (id) => {
        return axios.get(`/products/${id}`);
    },
    login: (username, password) => {
        return axios.post("/login", {
            "username": username,
            "password": password
        });
    }
}

export default GamingEShopService;