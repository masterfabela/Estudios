package aguinaldo;

public class MetodoGrat {
    float gratf,gratv;
    float t;
  public MetodoGrat(){} 
  public void calcgrat(Empregado e){
  switch(e.numf){
      case 0:
          gratf=gratf+180;
          break;
      case 1:
          gratf=gratf+240;
          break;
      case 2:
          gratf=gratf+300;
          break;
      default:
          gratf=gratf+360;
          break;
  }
  if((e.habs*6)<360){
  gratv=gratv+(360-(e.habs*6));
  }else{
  gratv=0f;
  }
  t=gratv+gratf;
  }
}
