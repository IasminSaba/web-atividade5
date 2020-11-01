<template>
  <div class="Editar"> 
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

    <br />  <p> </p>
    <button @click="update">Update</button>
  </div>
</template>

<script>
export default {
    name: "Editar",
    props: ["id"],
    
    data: function() {
        return {
            carro: {},
            baseURI: "http://localhost:8080/api/cars",
        };
    },
    created: function() {
        console.log(this.id);
        this.$http
        .get(this.baseURI + "/" + this.id)
        .then((result) => {
            this.carro = result.data;
        })
        .catch(function(error) {
            console.log(error);
        });
    },
    methods: {
        update: function() {
        console.log(this.carro);
        let obj = {
            id: this.carro.id,
            nome: this.carro.nome,
            marca: this.carro.marca,
            anoFabricacao: this.carro.anoFabricacao,
            anoModelo: this.carro.anoModelo,
            dataVenda: this.carro.dataVenda,
        };
        console.log(obj);

        this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
            //this.$router.push({ name: 'Users'});
        });
        },
    },
    };
</script>

<style>

</style>