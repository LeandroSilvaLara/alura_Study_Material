import { Header } from './components/Header';
import { Post } from "./Post.jsx";
export function App() {
  return (
      <div>
          <Header />
          <Post
            author="Leandro Lara"
            content="Lorem ispsun dolor sit amet consectetur adipiscing elite."
          />
          <Post
              author="Gabriel Buzzi"
              content="Um novo post muito legal"
          />
      </div>
  )
}

