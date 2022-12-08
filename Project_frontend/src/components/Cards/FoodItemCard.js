import React from "react";

const FoodItemCard = ({ items }) => {
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
      </div>
    </div>
  );
};

export default FoodItemCard;
