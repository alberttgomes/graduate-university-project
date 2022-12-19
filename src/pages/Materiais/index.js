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
import capaLivro1 from './../../imagens/img2.jpg'; 
import capaLivro2 from './../../imagens/img3.jpg'; 
import capaLivro3 from './../../imagens/img4.jpg'; 
import capaLivro4 from './../../imagens/img5.jpg'; 
import capaLivro5 from './../../imagens/img6.jpg'; 

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
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Gonçalves, Vitor Vaz, Cátia',
      datenews:new Date(),
      title:'CiberBullying: revisão sistemática da literatura',
      image:cyberbullimg,
      href:"https://bibliotecadigital.ipb.pt/bitstream/10198/23065/1/cyberbullying-1167-2477-1-SM-vg-cv.pdf" 
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Regina Rossetti, USCS, Ciro Ferreira da Silva Junior',
      datenews:new Date(),
      title:'Educação Digital',
      image:cyberbullimg,
      href:"https://drive.google.com/file/d/1r-kk7KB4KHTQEA1fLeq5NJmKFbocgRcW/view"
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Natália Pestana, Carolina Almeida, Filipe T. Moreira, Maria José Loureiro',
      datenews:new Date(),
      title:'Construindo cidadãos digitais',
      image:cyberbullimg,
      href:"https://revistas.pucsp.br/index.php/curriculum/article/view/55633/38416"
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Luciene Regina Paulino Tognetta, José Maria Avilés Martínez, Catarina Carneiro Gonçalves, Fernando Andrade, Larissa Di Genova Boni, Natália Cristina Pupin Santos',
      datenews:new Date(),
      title:'Validação de instrumento sobre engajamento e desengajamento moral de docentes diante do bullying na escola',
      image:cyberbullimg,
      href:"https://periodicos.fclar.unesp.br/iberoamericana/article/view/14477/10336"
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Machado, João da Silva',
      datenews:new Date(),
      title:'Cyberbullying: direcionamentos para uma discussão em sala de aula',
      image:cyberbullimg,
      href:"https://repositorio.unesp.br/bitstream/handle/11449/217983/machado_js_me_arafcl.pdf?sequence=3&isAllowed=y" 
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Gary W. Giumetti, Robin M. Kowalski',
      datenews:new Date(),
      title:'Cyberbullying nas redes sociais e bem-estar',
      image:cyberbullimg,
      href:"https://www.sciencedirect.com/science/article/pii/S2352250X22000161" 
   },    
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Carlos Evangelioa, Pablo Rodríguez-González, Javier Fernández-Río , Sixto Gonzalez-Villora',
      datenews:new Date(),
      title:'Cyberbullying em alunos do ensino fundamental e médio: uma revisão sistemática',
      image:cyberbullimg,
      href:"https://www.sciencedirect.com/science/article/abs/pii/S0360131521002335"
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Alexandra Maftei, Cornelia Măirean',
      datenews:new Date(),
      title:'Afinal, não é tão engraçado! Humor, pais, colegas e sua ligação com experiências de cyberbullying',
      image:cyberbullimg,
      href:"https://www.sciencedirect.com/science/article/abs/pii/S0747563222002709"
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Esperanza Debby Ng , Joelle Yan Xin Chua e Shefaly Shorey',
      datenews:new Date(),
      title:'A eficácia das intervenções educativas sobre bullying tradicional e cyberbullying entre adolescentes: uma revisão sistemática e meta-análise',
      image:cyberbullimg,
      href:"https://journals.sagepub.com/doi/abs/10.1177/1524838020933867"
   }, 
   {
      title1:"ARTIGOS CIENTIFICOS",
      author:'Robert Slonje, Peter K. Smith, Ann Frisen',
      datenews:new Date(),
      title:'A natureza do cyberbullying e estratégias de prevenção',
      image:cyberbullimg ,
      href:"https://www.sciencedirect.com/science/article/abs/pii/S0747563212002154"
   }, 
   {
      title1:"SUGESTÕES DE LIVROS",
      author:'Catarina Carneiro Gonçalves - Fernando Cézar Bezerra de Andrade',
      datenews:new Date(),
      title:'VIOLÊNCIAS E BULLYING NA ESCOLA: análise e prevenção',
      image:capaLivro1,
      href:"https://www.editoracrv.com.br/produtos/detalhes/31087-violencias-e-bullying-na-escolabranalise-e-prevencao"
   }, 
   {
      title1:"SUGESTÕES DE LIVROS",
      author:'Merle Horowitz, Dorothy M. Bollinger',
      datenews:new Date(),
      title:'Cyberbullying nas Mídias Sociais em Instituições Educacionais',
      image:capaLivro2,
      href:"https://books.google.com.br/books?hl=pt-BR&lr=&id=9iovBQAAQBAJ&oi=fnd&pg=PR7&dq=livros+cyberbullying+in+social+media+within+educational+institutions:+featuring+student,+employee,+and+parent+information&ots=ry0dkSMQea&sig=6X7HY1ca8mrr_Mi4pYAxvrUm5zg#v=onepage&q&f=false"
   }, 
   {
      title1:"SUGESTÕES DE LIVROS",
      author:'Maria auxiliadora elias',
      datenews:new Date(),
      title:'Violência Escolar',
      image:capaLivro3,
      href:"https://www.estantevirtual.com.br/livros/maria-auxiliadora-elias/violencia-escolar/767596071?show_suggestion=0"
   }, 
   {
      title1:"SUGESTÕES DE LIVROS",
      author:'Antônio A. S. Zuin',
      datenews:new Date(),
      title:'Fúria narcísica entre alunos e professores',
      image:capaLivro4,
      href:"https://books.google.com.br/books?hl=pt-BR&lr=&id=Iik9EAAAQBAJ&oi=fnd&pg=PA2&dq=cyberbullying+teses+de+doutorado&ots=5Dlo3CwmP0&sig=pEbFvouJA_CQ50ed8qupcVT4Jk4#v=onepage&q=cyberbullying%20teses%20de%20doutorado&f=false"
   }, 
   {
      title1:"SUGESTÕES DE LIVROS",
      author:'Neide Aparecida Ribeiro',
      datenews:new Date(),
      title:'CYBERBULLYING: PRÁTICAS E CONSEQUÊNCIAS DA VIOLÊNCIA VIRTUAL NA ESCOLA (2019)',
      image:capaLivro5,
      href:"https://www.editorajuspodivm.com.br/cyberbullying-praticas-e-consequencias-da-violencia-virtual-na-escola-2019 "
   }, 
   {
      title1:"Sugestões de Dissertações e teses:",
      author:'Lopes, Joana Filipa Bastos',
      datenews:new Date(),
      title:'Discurso de ódio online : revisão sistemática dos fatores individuais e de contexto',
      image:cyberbullimg,
      href:"https://recil.ensinolusofona.pt/bitstream/10437/12223/1/Joana%20Filipa%20Bastos%20Lopes%2c%2021802990.pdf"
   }, 
   {
      title1:"Sugestões de Dissertações e teses:",
      author:'Ribeiro, Neide Aparecida',
      datenews:new Date(),
      title:'Cyberbullying: práticas e consequências da violência virtual na escola',
      image:cyberbullimg,
      href:"https://bdtd.ucb.br:8443/jspui/handle/tede/2515#preview-link0"
   }, 
   {
      title1:"Sugestões de Dissertações e teses:",
      author:'Gonçalves, Catarina Carneiro',
      datenews:new Date(),
      title:'Engajamento e desengajamento moral de docentes em formação diante de situações de bullying envolvendo alvos típicos e provocadores',
      image:cyberbullimg,
      href:"https://repositorio.ufpb.br/jspui/bitstream/tede/9914/2/Arquivototal.pdf"
   }, 
   {
      title1:"Sugestões de Podcasts:",
      author:' Rodrigo Nejm, Jana Bauer, Dalmo Lemos, pais da Cacai Bauer',
      datenews:new Date(),
      title:'o combate ao cyberbullying',
      image:cyberbullimg,
      href:"https://www.dialogando.com.br/seguranca/ouca-o-podcast-o-combate-ao-cyberbullying"
   }, 
   {
      title1:"Sugestões de Podcasts:",
      author:' Ana Carolina Malvão e Hugo Rosas',
      datenews:new Date(),
      title:'Chão de escola:',
      image:cyberbullimg,
      href:"https://pt.player.fm/series/2643503"
   }, 
   {
      title1:"Sugestões de Podcasts:",
      author:'Kevin Alves Da Silva',
      datenews:new Date(),
      title:'Cyberbullying',
      image:cyberbullimg,
      href:"https://open.spotify.com/show/7JfXTaZU5gLslSkbOBbfgX"
   }, 
   {
      title1:"Sugestões de Podcasts:",
      author:'Brasil escola',
      datenews:new Date(),
      title:'Sociologia #15: A violência por trás do cyberbullying',
      image:cyberbullimg,
      href:"https://brasilescola.uol.com.br/podcasts/a-violencia-por-tras-do-cyberbullying.htm"
   }, 
   {
      title1:"Sugestões de Podcasts:",
      author:'Convivere mais',
      datenews:new Date(),
      title:'Podcasts',
      image:cyberbullimg,
      href:"https://www.conviveremais.com.br/categoria-produto/podcasts/"
   }, 

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
                              <Typography variant="h4" align="center">
                                 {data.title1}
                              </Typography>
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
                                    {`${data.author}`}
                                 </Typography>
                              </CardContent>
                              <CardActions>
                                 <Button size="medium" href={data.href} >Ver</Button>
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
