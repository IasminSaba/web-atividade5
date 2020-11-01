<template>
  <div class="BuscarCarro">
    <h1>
        Busca por ID
    </h1>
    
    <br/>
    <p/>
    ID: {{carro.id}} --
    Nome: {{carro.nome}}
    <br/>
    Marca: {{carro.marca}}
    <br/>
    Ano de Fabricação: {{carro.anoFabricacao}}
    <br/>
    Ano do Modelo: {{carro.anoModelo}}
    <br/>
    Data da Venda: {{carro.dataVenda}}
  </div>
  
</template>

<script>
export default {
    name: 'BuscarCarro',
    props: ["id"],
    data: function (){
        return{
            
            carro: {},
            baseURI: "http://localhost:8080/api/cars"
        }
    }, 
    created: function() {
             this.$http
             .get(this.baseURI + "/" + this.id)
             .then((result) => {
                this.carro = result.data;
            })
            .catch(function(error) {
                console.log(error);
            });
    },
}
</script>

<style>
</style>