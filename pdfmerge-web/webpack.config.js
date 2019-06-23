module.exports = {
    entry: [
        './src/PDFMerge.jsx'
    ],
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: ['babel-loader']
            },
            {
                test: /\.css$/,
                loader:[ 'style-loader', 'css-loader' ]
            }
        ]
    },
    output: {
        path: __dirname + '/static',
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.js', '.jsx'],
        alias: {
            components: __dirname + '/src/components',
            containers: __dirname + '/src/containers',
            utils: __dirname + '/src/utils',
        }
    }
};