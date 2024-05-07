
const typewriter = document.querySelector('.typewriter');
 let text = typewriter.innerText;
 let i = 0;

 function typeWriter() {
   if (i < text.length) {
   typewriter.innerText = text.substring(0, i + 1);
    i++;
     setTimeout(typeWriter, 50); // Adjust speed here (optional)
                  }
             }

         typeWriter();