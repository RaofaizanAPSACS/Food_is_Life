import React, { useEffect, useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import CartCard from "components/Cards/CartCard";

axios.defaults.withCredentials = true;
axios.defaults.headers.post["Content-Type"] = "application/json";

function Cart() {
  const [foodItems, setFoodItems] = useState([]);

  const getAllFoodItems = () => {
    axios.get("http://localhost:8086/NGO/Cart/fetchCartItems")
      .then(response => {
        console.log(response.data);
        setFoodItems(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  useEffect(() => {
    getAllFoodItems();
  }, []);

  const handleOrder = () => {
    const currentDateTime = new Date().toISOString(); // Format date as ISO string for JSON compatibility
    // You need to provide a way to set the rider_cnic, possibly from user selection or another method
    const riderCnic = "123456789012"; // Example CNIC, replace with actual data

    const orderDetails = {
      orderTime: currentDateTime,
      orderStatus: "Pending", // Assume initial status as "Pending"
      pickupTime: currentDateTime, // For example use, adjust as needed
      rider_cnic: riderCnic,
      items: foodItems // Assuming backend expects items within the order
    };

    axios.post("http://localhost:8086/NGO/Cart/order", orderDetails)
      .then(response => {
        console.log("Order response:", response.data);
        if (response.data === "Order Booked") {
          setFoodItems([]); // clear cart on successful order
          alert('Order successfully placed!');
        } else {
          alert(response.data); // handle other messages from the backend
        }
      })
      .catch(error => {
        console.error("Order error:", error);
        alert('Failed to place the order.');
      });
  };

  return (
    <Container className="m-0 text-right">
      <ToastContainer />
      <div className="pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center">CART ITEMS</h1>
        {foodItems.length > 0 ? (
          foodItems.map((item, index) => <CartCard key={index} items={item} />)
        ) : (
          "NO ITEM IN THE CART"
        )}
        {foodItems.length > 0 && (
          <button onClick={handleOrder} className="bg-black hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-4">
            Order Items
          </button>
        )}
      </div>
    </Container>
  );
}

export default Cart;
