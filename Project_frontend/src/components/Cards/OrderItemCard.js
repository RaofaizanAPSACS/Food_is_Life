import React from "react";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const OrderItemCard = ({ items }) => {
  const handleCart = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8086/NGO/Cart/addToCart", {
        storeName: items.branch.name,
        bid: items.branch.bid,
        itemID: items.leftover.itemID,
        itemName: items.foodItem.itemName,
        quantity: items.leftover.quantity,
      })
      .then((result) => {
        console.log(result.data);
        notify();
      })
      .catch((err) => console.log(err));
  };

  const notify = () => {
    toast.success("Item Added to Cart");
  };
  return (
    <div className="cont">
      <ToastContainer />
      <div className="contacts ">
        <div className="contact-card">
          <img
            src={require("../../assets/images/leffover.png").default}
            alt="1"
          />
          <h3>{items.foodItem.itemName}</h3>
          <div className="info-group">
            <img src={require("../../assets/images/id.jpg").default} alt="2" />
            <p>{items.branch.name}</p>
          </div>
          <div className="info-group">
            <img src={require("../../assets/images/res.png").default} alt="2" />
            <p>{items.foodItem.itemDescription}</p>
          </div>
          <div className="info-group">
            <img
              src={require("../../assets/images/description.jpg").default}
              alt="3"
            />
            <p>{items.leftover.quantity}</p>
          </div>
          <div className="info-group">
            <img
              src={require("../../assets/images/description.jpg").default}
              alt="3"
            />
            <p>{items.leftover.bestBefore}</p>
          </div>
          <div className="info-group">
            <img
              src={require("../../assets/images/description.jpg").default}
              alt="3"
            />
            <p>{items.branch.address}</p>
          </div>
        </div>
        <form onSubmit={handleCart}>
          <div className="text-center mt-6">
            <button
              className="bg-blueGray-800 text-white active:bg-blueGray-600 text-sm font-bold uppercase px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 w-full ease-linear transition-all duration-150"
              type="submit"
            >
              Add To Cart
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default OrderItemCard;
