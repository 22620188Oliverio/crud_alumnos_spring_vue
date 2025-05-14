<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const alumnos = ref([]);

const cargarAlumnos = async () => {
  try {
    const response = await axios.get('http://localhost:8080/alumnos/traer-alumnos');
    alumnos.value = response.data;
    console.log(alumnos.value);
  } catch (error) {
    console.error("Error al cargar alumnos:", error);
  }
};

onMounted(cargarAlumnos);
</script>

<template>
  <div class="container">
    <button class="btn btn-primary">
      boton
    </button>
  </div>
</template>

<style scoped></style>
