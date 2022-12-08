import React, { useEffect, useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import FoodItemCard from "components/Cards/FoodItemCard";
import axios from "axios";
axios.defaults.withCredentials = true;

function DisplayFoodItems() {
  const AllFoodItems = () => {
    useEffect(() => {}, []);
  };
  const getAllFoodItems = () => {
    axios.get("http://localhost:8086//displayFoodItems").then(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  };
  useEffect(() => {
    getAllFoodItems();
  }, []);

  const [foodItems, setFoodItems] = useState([
    {
      id: "1",
      itemName: "Burger",
      storeName: "KFC",
      itemDescription: "Crunchyyyyy",
    },
  ]);

  const handleFoodItems = (event) => {
    setFoodItems(...foodItems, event.target.value);
  };

  return (
    <Container className=" text-right">
      <ToastContainer />
      <div className=" pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center ">Food Item</h1>
        {foodItems.length > 0
          ? foodItems.map((item) => <FoodItemCard items={item} />)
          : "No Food Items"}
      </div>
    </Container>
  );
}

export default DisplayFoodItems;
