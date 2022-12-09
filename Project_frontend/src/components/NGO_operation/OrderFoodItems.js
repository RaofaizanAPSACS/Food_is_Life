import React, { useEffect, useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import OrderItemCard from "components/Cards/OrderItemCard";
axios.defaults.withCredentials = true;
axios.defaults.headers.get["Access-Control-Allow-Origin"] = "*";
function OrderFoodItems() {
  const getAllFoodItems = () => {
    axios.get("http://localhost:8086/NGO/OrderFoodItems").then(
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
        <h1 className="font-bold text-4xl text-center ">LEFTOVERS</h1>
        {foodItems.length > 0
          ? foodItems.map((item) => <OrderItemCard items={item} />)
          : "NO ITEMS AVAILABLE"}
      </div>
    </Container>
  );
}

export default OrderFoodItems;
