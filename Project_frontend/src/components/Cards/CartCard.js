import React from "react";

const CartCard = ({ items }) => {
  return (
    <div className="cont">
      <div className="rider ">
        <div className="rider-card">
          <h3>{items.itemName}</h3>
          <div className="info-rider">
            <img src={require("../../assets/images/id.jpg").default} alt="2" />
            <h3>{items.itemID}</h3>
          </div>
          <div className="info-rider">
            <img
              src={require("../../assets/images/phone.jfif").default}
              alt="2"
            />
            <p>{items.storeName}</p>
          </div>
          <div className="info-rider">
            <img
              src={require("../../assets/images/email.png").default}
              alt="3"
            />
            <p>{items.quantity}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CartCard;
