import React, { useEffect, useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import CartCard from "components/Cards/CartCard";
axios.defaults.withCredentials = true;
axios.defaults.headers.get["Access-Control-Allow-Origin"] = "*";
function Cart() {
  const getAllFoodItems = () => {
    axios.get("http://localhost:8086/NGO/Cart/fetchCartItems").then(
      (response) => {
        console.log(response.data);
        setFoodItems(response.data);
      },
      (error) => {
        console.log(error);
      }
    );
  };
  useEffect(() => {
    getAllFoodItems();
  }, []);

  const [foodItems, setFoodItems] = useState([]);

  return (
    <Container className=" m-0 text-right">
      <ToastContainer />
      <div className=" pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center ">CART ITEMS</h1>
        {foodItems.length > 0
          ? foodItems.map((item) => <CartCard items={item} />)
          : "NO ITEM IN THE CART"}
      </div>
    </Container>
  );
}

export default Cart;
