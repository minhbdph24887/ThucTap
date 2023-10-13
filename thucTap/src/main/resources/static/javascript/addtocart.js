const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {
    /*
        QUẢN LÝ GIỎ HÀNG
    */
    $scope.cart = {
        listProduct: [],
        // Thêm sản phẩm vào giỏ hàng
        add(idProduct) {
            var item = this.listProduct.find(item => item.idProductItems == idProduct);
            var urlAdd = "http://localhost:8080/product/" + idProduct;
            if (item) {
                item.qty++;
                this.saveToLoaclStorage();
            } else {
                $http.get(urlAdd).then(resp => {
                    resp.data.availableQuantity = 1;
                    this.listProduct.push(resp.data);
                    this.saveToLoaclStorage();
                })
            }
        },


        // Lưu giỏ hàng vào local storage
        saveToLoaclStorage() {
            var json = JSON.stringify(angular.copy(this.listProduct));
            localStorage.setItem("cart", json);
        },

        // Tính tổng số lượng mặt hàng trong giỏ
        get count() {
            return this.listProduct
                .map(listProduct => listProduct.availableQuantity)
                .reduce((total, availableQuantity) => total += availableQuantity, 0);
        },

        // Tổng số tiền các mặt hàng trong giỏ
        get totalCost() {
            return this.listProduct
                .map(listProduct => listProduct.availableQuantity * listProduct.costPrice)
                .reduce((total, availableQuantity) => total += availableQuantity, 0);
        },

        // Đọc giỏ hàng từ Local Storage
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.listProduct = json ? JSON.parse(json) : [];
        },

        // Xoá từng sản phẩm trong giỏ hàng
        remove(idProduct) {
            var index = this.listProduct.findIndex(listProduct => listProduct.idProduct == idProduct);
            this.listProduct.splice(index, 1);
            this.saveToLoaclStorage();
        },

        // Xoá toàn bộ sản phẩm trong giỏ hàng
        clear() {
            this.listProduct = [];
            this.saveToLoaclStorage();
        }
    }
    $scope.cart.loadFromLocalStorage();
});