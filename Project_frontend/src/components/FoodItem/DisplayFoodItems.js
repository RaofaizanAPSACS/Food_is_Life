import React, { useEffect, useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import FoodItemCard from "components/Cards/FoodItemCard";
import axios from "axios";
axios.defaults.withCredentials = true;
axios.defaults.headers.get["Access-Control-Allow-Origin"] = "*";
function DisplayFoodItems() {
  const getAllFoodItems = () => {
    axios.get("http://localhost:8086/displayFoodItems").then(
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
        <h1 className="font-bold text-4xl text-center ">FOOD ITEMS</h1>
        {foodItems.length > 0
          ? foodItems.map((item) => <FoodItemCard items={item} />)
          : "No Food Items"}
      </div>
    </Container>
  );
}

export default DisplayFoodItems;
