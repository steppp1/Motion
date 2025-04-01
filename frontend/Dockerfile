# 使用 Node.js 构建前端
FROM node:18 AS builder
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# 使用 Nginx 运行静态文件
FROM nginx:1.21
# 1. 删除默认配置
RUN rm /etc/nginx/conf.d/default.conf

# 2. 复制自定义Nginx配置
COPY nginx.conf /etc/nginx/conf.d/

# 3. 复制构建产物（包括压缩文件）
COPY --from=builder /app/dist /usr/share/nginx/html

# 4. 暴露端口并启动
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]  # 保持前台运行