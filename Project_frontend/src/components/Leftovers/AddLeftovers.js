import React, { useState } from "react";
import Container from "@material-ui/core/Container";

import LeftoversCard from "components/Cards/LeftoversCard";
import axios from "axios";
import { useEffect } from "react";

function AddLeftovers() {
  const [foodItems, setFoodItems] = useState([]);

  const getAllFoodItems = () => {
    axios.get("http://localhost:8086/displayFoodItems").then(
      (response) => {
        console.log(response.data);

        setFoodItems(response.data);
      },
      (error) => {
        console.log(error);
        window.location.href = "/LoginRestaurant";
      }
    );
  };

  useEffect(() => {
    getAllFoodItems();
  }, []);

  return (
    <Container className=" text-right">
      <div className=" pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center ">ADD LEFTOVERS</h1>
        {foodItems.length > 0
          ? foodItems.map((item) => <LeftoversCard items={item} />)
          : "No Food Items"}
      </div>
    </Container>
  );
}

export default AddLeftovers;
