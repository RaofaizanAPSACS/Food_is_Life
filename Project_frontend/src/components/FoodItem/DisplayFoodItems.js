import React, { useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import FoodItemCard from "components/Cards/FoodItemCard";
function DisplayFoodItems() {
  const [foodItems, setFoodItems] = useState([
    {
      id: "1",
      itemName: "Burger",
      storeName: "KFC",
      itemDescription: "Crunchyyyyy",
    },
    {
      id: "2",
      itemName: "Pizza",
      storeName: "Broadway",
      itemDescription: "Cheesyy",
    },
    {
      id: "2",
      itemName: "Pizza",
      storeName: "Broadway",
      itemDescription: "Cheesyy",
    },
    {
      id: "2",
      itemName: "Br",
      storeName: "Broadway",
      itemDescription: "Cheesyy",
    },
    {
      id: "2",
      itemName: "Pizza",
      storeName: "Broadway",
      itemDescription: "Cheesyy",
    },
  ]);

  // const handleFoodItems = (event) => {
  //   setFoodItems(...foodItems, event.target.value);
  // };

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
