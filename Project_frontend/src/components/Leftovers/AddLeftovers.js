import React, { useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import LeftoversCard from "components/Cards/LeftoversCard";
import axios from "axios";
import { useEffect } from "react";
import { StyledEngineProvider } from "@mui/material";

function AddLeftovers() {
  const [foodItems, setFoodItems] = useState([]);
  const notify = () => {
    toast.warn("Session Timed Out");
  };
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
      <ToastContainer />
      <div className=" pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center ">Add Leftovers Item</h1>
        {foodItems.length > 0
          ? foodItems.map((item) => <LeftoversCard items={item} />)
          : "No Food Items"}
      </div>
    </Container>
  );
}

export default AddLeftovers;
