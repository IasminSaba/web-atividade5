<template>
  <div class="principal">
    <h1>Cadastro</h1>
    <h3>Nome:</h3>
    <input type="text" name id="nome" v-model="carro.nome" />
    <br />

    <h3>Marca:</h3>
    <input type="text" name id="marca" v-model="carro.marca" />
    <br />

    <h3>Ano de Fabricação:</h3>
    <input type="text" name id="anoFabricacao" v-model="carro.anoFabricacao" />
    <br />

    <h3>Ano do modelo:</h3>
    <input type="text" name id="anoModelo" v-model="carro.anoModelo" />
    <br />

    <h3>Data de Venda:</h3>
    <input type="text" name id="dataVenda" v-model="carro.dataVenda" />
    
    <br />   <br /> <br />

    <button @click="insertCarro">Cadastrar</button>

    <br />    <p> </p> 
    
    <button @click="getAll">Listar</button>

    <h3>Campo id para busca, deleção e atualizações</h3>
    <h3>ID</h3>
    <input type="text" v-model="id" />

    <br />  <p> </p>
    <button @click="getRegistro">Buscar</button>

    <br />  <p> </p>
    <button @click="$router.push({ name: 'Editar' })">Update</button>
    
    <br />  <p> </p>
    <button @click="deleteById">Delete</button>
  </div>
</template>

<script>
export default {
  name: 'Principal',
  
  data: function() {
    return {
      id: "",
      carro: {},
      carros: [],
      nome: "",
      marca: "",
      anoFabricacao: "",
      anoModelo: "",
      dataVenda: "",
      baseURI: "http://localhost:8080/api/cars",
      algumCampo: "",
    };
  },
  created: function() {
    this.$http.get(this.baseURI).then(result => {
        this.carros = result.data;
      });
  },
  methods: {
    insertCarro: function() {
      let obj = {
        nome: this.nome,
        marca: this.marca,
        anoFabricacao: this.anoFabricacao,
        anoModelo: this.anoModelo,
        dataVenda: this.dataVenda,
      };

      this.$http.post(this.baseURI, obj).then(result => {
        if (result.data != "") {
         this.$router.push({ name: 'Carros'});
        }
      });
    },

    getAll: function() {
      this.$http.get(this.baseURI).then(result => {
        this.carros = result.data;
        this.$router.push({ name: 'Carros'});
      });
    },

    getRegistro: function (){
            this.$http
             .get(this.baseURI + "/" + this.id)
             .then((result) => {
                this.carro = result.data;
                alert(this.carro);
                console.log(this.carro);
                this.$router.push({ name: 'BuscarCarro',  params: { id: this.carro.id } });
            })
            .catch(function(error) {
                console.log(error);
            });
    },

    // update: function() { //Fazendo do jeito difícil

    //    this.$http
    //          .get(this.baseURI + "/" + this.id)
    //          .then((result) => {
    //             this.carro = result.data;});
    //   console.log(this.carro.nome);
    //   this.getRegistro();
    //   this.algumCampo = "nome"; //id no html
    //   var aux1 = this.validarCampo(this.nome,this.carro.nome);
    //   this.algumCampo = "marca";      
    //   var aux2 = this.validarCampo(this.marca,this.carro.marca);
    //   this.algumCampo = "anoFabricacao";      
    //   var aux3 = this.validarCampo(this.anoFabricacao,this.carro.anoFabricacao);
    //   this.algumCampo = "anoModelo";      
    //   var aux4 = this.validarCampo(this.anoModelo,this.carro.anoModelo);
    //   this.algumCampo = "dataVenda";      
    //   var aux5 = this.validarCampo(this.dataVenda,this.carro.dataVenda);
    //   console.log(JSON.stringify(this.carro));

    //   let obj = {
    //     nome: aux1,
    //     marca: aux2,
    //     anoFabricacao: aux3,
    //     anoModelo: aux4,
    //     dataVenda: aux5,
    //   };
    //   console.log(this.carro);
      
    //   this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
    //     this.$router.push({ name: 'Carros'});
    //   });
    // },

    deleteById: function() {
      this.$http.delete(this.baseURI + "/" + this.id).then((result) => {
        this.$router.push({ name: 'Carros'});
      });
    },
    // validarCampo: function(primeiro, segundo){
    //        var campo = document.getElementById(this.algumCampo);
    //         if(campo.value.length != 0){
    //             //alert("aqwjkd");
    //             console.log("aqui entrou");
    //             return primeiro;
    //         }
    //         console.log("aqui onde é false");
                
    //         return segundo;

    //   }
  }
};
</script>

<style>

</style>
