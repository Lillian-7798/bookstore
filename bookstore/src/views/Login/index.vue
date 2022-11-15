<template>
  <div>
    <Header />
    <Info />
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import Info from "./info";
export default {
  // name: 'Login',
  components:{
    Header,
    Info,
    Footer
  },
}
</script>

<style scoped>

</style>