document.addEventListener('DOMContentLoaded', () => {
    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        form.addEventListener('submit', (event) => {
            if (!validarFormulario(form)) {
                event.preventDefault();
            } else {
                const submitBtn = form.querySelector('button[type="submit"]');
                if (submitBtn) {
                    submitBtn.disabled = true;
                    submitBtn.innerText = 'A processar...';
                }
            }
        });
    });
});

function validarFormulario(form) {
    const inputs = form.querySelectorAll('input[type="text"], input[type="number"]');
    let valido = true;

    inputs.forEach(input => {
        const valor = input.value.trim();
        input.style.borderColor = '#cbd5e1';

        if (input.hasAttribute('required') && valor === '') {
            valido = false;
            input.style.borderColor = '#e53e3e';
        }

        if (input.name === 'anoPublicacao' && valor !== '') {
            const ano = parseInt(valor, 10);
            const anoAtual = new Date().getFullYear();

            if (isNaN(ano) || ano < 1000 || ano > anoAtual) {
                valido = false;
                input.style.borderColor = '#e53e3e';
            }
        }
    });

    return valido;
}