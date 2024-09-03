const path = require('path');

module.exports = {
    openapi: '3.0.0',
    info: {
        title: 'nissan API',
        version: '1.0.0',
        description: 'Microservice nissan API',
    },
    servers: [
        { url: 'http://localhost:3905' }
    ],
    apis: [path.join(__dirname, './src/**/**/*.ts')]
};
