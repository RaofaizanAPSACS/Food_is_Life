import React, { useState } from "react";
import axios from "axios";
import Moment from "moment";
const LeftoversCard = ({ items }) => {
  const [quantity, setQuantity] = useState("");
  const [bestBefore, setBestBefore] = useState("");
  const dateToFormat = "1976-04-19";
  <Moment>{dateToFormat}</Moment>;

  const handleQuantity = (event) => {
    setQuantity(event.target.value);
  };
  const handleBestBefore = (event) => {
    setBestBefore(event.target.value);
  };
  const handleLeftoverItem = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8086/addLeftovers", {
        itemID: items.itemID,
        quantity: quantity,
        bestBefore: bestBefore,
      })
      .then((result) => {
        console.log(result.data);
        if (result.data === "Leftovers Added") {
          alert("Leftovers Added");
        } else {
          alert("Session Logged Out");
        }
      })
      .catch((err) => console.log(err));
  };
  return (
    <div className="cont">
      <div className="contacts ">
        <div className="contact-card">
          <img
            src={require("../../assets/images/download_1.png").default}
            alt="1"
          />
          <h3>{items.itemName}</h3>
          <div className="info-group">
            <img src={require("../../assets/images/id.jpg").default} alt="2" />
            <p>{items.itemID}</p>
          </div>
          <div className="info-group">
            <img src={require("../../assets/images/res.png").default} alt="2" />
            <p>{items.resName}</p>
          </div>
          <div className="info-group">
            <img
              src={require("../../assets/images/description.jpg").default}
              alt="3"
            />
            <p>{items.itemDesc}</p>
          </div>
        </div>
        <form onSubmit={handleLeftoverItem}>
          <div className="relative w-full mb-3">
            <label
              className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
              htmlFor="grid-password"
            >
              Add Quantity
            </label>
            <input
              type="number"
              min={0}
              className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
              placeholder="Quantity"
              value={quantity}
              onChange={handleQuantity}
              required={true}
            />
          </div>
          <div className="relative  mb-3">
            <label
              className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
              htmlFor="grid-password"
            >
              Best Before
            </label>
            <input
              type="date"
              className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
              value={bestBefore}
              pattern={dateToFormat}
              onChange={handleBestBefore}
              required={true}
            />
          </div>
          <div className="text-center mt-6">
            <button
              className="bg-blueGray-800 text-white active:bg-blueGray-600 text-sm font-bold uppercase px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 w-full ease-linear transition-all duration-150"
              type="submit"
            >
              Add
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LeftoversCard;
