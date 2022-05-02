


import './quemsomos.css'


const  QuemSomos = () =>{
    return(
      <div className='cont'>
         
                <div>
                       <h1>Quem somos</h1>
                </div>

                <div>
                     <h1>Contate-nos</h1>
                     <div class="row">
                        <div className="col">
                          <input type="text" className="form-control" placeholder="First name" aria-label="First name"/>
                        </div>
                        <div className="col">
                          <input type="text" className="form-control" placeholder="Last name" aria-label="Last name"/>
                        </div>
                     </div>
                </div>

         

      </div>
    )
}

export default QuemSomos