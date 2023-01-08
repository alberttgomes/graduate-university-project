import { useState,useEffect } from "react";
import "./Materiais.css";
import AOS from "aos";
import "aos/dist/aos.css";
import Button from '@mui/material/Button';
import Denuncia from "../../components/denuncia/Denuncia";
import { Card, 
         CardActions, 
         CardContent, 
         CardMedia, 
         Container, 
         Grid, 
         Typography } from '@mui/material';
import cyberbullimg from './../../imagens/imagem1.png'; 

export const data = [
   {
      author:'Professora Paloma.',
      datenews:new Date(),
      title:'cyberbullying',
      image:cyberbullimg 
   }, 
   {
      author:'Professora Paloma.',
      datenews:new Date(),
      title:'cyberbullying',
      image:cyberbullimg 
   }, 
   {
      author:'Professora Paloma.',
      datenews:new Date(),
      title:'cyberbullying',
      image:cyberbullimg 
   } 

]


const Materiais = () => {

  useEffect(() => {
    AOS.init({
      duration: 1000,
    });
  }, []);

  return (
    <div id="materiais">

      <section className="wrapper">
         <a href="#section3" class="arrow__btn left-arrow">‹</a>
               <Container sx={{ py: 5 }} maxWidth="md">
                  <Grid container spacing={4}>
                     {data.map((data, index) => (
                        <Grid item  xs={12} sm={6} md={4}>
                           <Card
                              className="item"
                              key={index}
                              sx={{ 
                                 height:'100%', 
                                 display: 'flex', 
                                 flexDirection: 'column' 
                              }}
                           >
                              <CardMedia
                                 component="img"
                                 sx={{
                                    pt: '20%',
                                 }}
                                 image={data.image}
                                 alt="random"
                              />
                              <CardContent sx={{ flexGrow: 1 }}>
                                 <Typography gutterBottom variant="h5" component="h2">
                                    {data.title}
                                 </Typography>
                                 <Typography>
                                    {`${data.author} • ${data.datenews}`}
                                 </Typography>
                              </CardContent>
                              <CardActions>
                                 <Button size="medium">Ver</Button>
                              </CardActions>
                           </Card>
                        </Grid>
                     ))}
                  </Grid>
            </Container>   
         <a href="#section1" class="arrow__btn right-arrow">›</a>
      </section>

      <div className="btn-denuncia">
         <Denuncia/>
      </div>
    
    </div>
  );
}

export default Materiais;
