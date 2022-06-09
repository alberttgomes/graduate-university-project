
import React from 'react'

import "./card.css"

const CardComponent = ({image, text, link, title}) => {
  return (
    <div className="card" >
       
             <img className="cardImg" src={image} alt={`Card ${image}`}/>
       
      <div>
              <h4 style={{color : 'black', alignSelf : 'flex-start', marginLeft : 5}}>{title}</h4>
              <p >{text}</p>
              <button>
                 <a href={link} style={{color : 'black'}}>
                 Acessar Post
                 </a>
              </button>   
      </div>
    </div>
  )
}

export default CardComponent