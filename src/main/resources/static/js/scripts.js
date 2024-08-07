document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const button = form.querySelector('button');

    form.addEventListener('submit', function() {
        button.disabled = true;
        button.textContent = 'Searching...';
    });

    const resultItems = document.querySelectorAll('.result-item');
    resultItems.forEach(item => {
        item.addEventListener('mouseenter', () => {
            item.style.backgroundColor = '#f0f0f5';
        });

        item.addEventListener('mouseleave', () => {
            item.style.backgroundColor = '#fff';
        });
    });

    const toggleHeaders = document.querySelectorAll('.toggle-header');
    toggleHeaders.forEach(header => {
        header.addEventListener('click', () => {
            const content = header.nextElementSibling;
            if (content.style.display === 'none' || content.style.display === '') {
                content.style.display = 'block';
                header.textContent = header.textContent.replace('▼', '▲');
            } else {
                content.style.display = 'none';
                header.textContent = header.textContent.replace('▲', '▼');
            }
        });
    });
});
