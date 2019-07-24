module.exports = {
    plugins: [
      require('tailwindcss'),
      require('autoprefixer'),
      process.env.BUILD_ENV === 'prod' && require('@fullhuman/postcss-purgecss')({
        content: [
          './resources/public/index.html',
          './src/workation/core.cljs'
        ],
        defaultExtractor: content => content.match(/[A-Za-z0-9-_:/]+/g) || []
      }),
      process.env.BUILD_ENV === 'prod' && require('cssnano')
    ]
}
